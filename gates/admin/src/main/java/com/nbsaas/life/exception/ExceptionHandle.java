package com.nbsaas.life.exception;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.system.api.apis.ErrorLogApi;
import com.nbsaas.life.system.api.domain.request.ErrorLogDataRequest;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@ControllerAdvice
public class ExceptionHandle {

    @Resource
    private ErrorLogApi sysErrorLogApi;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseObject<?> handler(Exception e, HttpServletRequest request) {

        if (e instanceof UnauthorizedException) {
            return ResponseObject.error(403, "权限不足");
        } else if (e instanceof UnauthenticatedException) {
            return ResponseObject.error(401, "没有登录");
        } else if (e instanceof BindException) {
            BindException exception = (BindException) e;
            List<ObjectError> errors = exception.getBindingResult().getAllErrors();
            if (errors.size() > 0) {
                return ResponseObject.error(406, errors.get(0).getDefaultMessage());
            }
            return ResponseObject.error(406, exception.getMessage());
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException exception = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
            System.out.println(exception.getMessage());
            if (violations.size() > 0) {
                return ResponseObject.error(406, violations.iterator().next().getMessage());
            }
            return ResponseObject.error(406, exception.getMessage());
        } else if (e instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException exception = (MissingServletRequestParameterException) e;
            return ResponseObject.error(406, "参数" + exception.getParameterName() + "没有传");
        } else {
            e.printStackTrace();
            this.savaLog(e, request);
            return ResponseObject.error(500, "未知错误");
        }
    }

    private void savaLog(Exception ex, HttpServletRequest request) {
        if (request == null) {
            return;
        }

        ErrorLogDataRequest bean = new ErrorLogDataRequest();
        bean.setName(ex.getClass().getSimpleName());
        bean.setNote(getError(ex));
        bean.setApp("ims");
        bean.setUrl(request.getRequestURL().toString());
        StringBuffer buffer = new StringBuffer();
        Map map = request.getParameterMap();
        Set set = map.keySet();
        if (set != null) {
            for (Object o : set) {
                buffer.append(o + "=");
                buffer.append(request.getParameter(o + "") + "\n");
            }
        }
        bean.setParam(buffer.toString());
        Properties props = System.getProperties();
        bean.setServerName(props.getProperty("user.name"));
        sysErrorLogApi.create(bean);
    }

    public static String getError(Exception ex) {
        ByteArrayOutputStream out = null;
        PrintStream pout = null;
        String ret = "";
        try {
            out = new ByteArrayOutputStream();
            pout = new PrintStream(out);
            ex.printStackTrace(pout);
            ret = out.toString();
            out.close();
        } catch (Exception e) {
            return ex.getMessage();
        } finally {
            if (pout != null) {
                pout.close();
            }
        }
        return ret;
    }
}
