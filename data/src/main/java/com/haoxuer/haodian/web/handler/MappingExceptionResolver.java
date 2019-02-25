package com.haoxuer.haodian.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MappingExceptionResolver extends SimpleMappingExceptionResolver {

	/**
	 * Actually resolve the given exception that got thrown during on handler
	 * execution, returning a ModelAndView that represents a specific error page
	 * if appropriate.
	 * <p>
	 * May be overridden in subclasses, in order to apply specific exception
	 * checks. Note that this template method will be invoked <i>after</i>
	 * checking whether this resolved applies ("mappedHandlers" etc), so an
	 * implementation may simply proceed with its actual exception handling.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @param handler
	 *            the executed handler, or {@code null} if none chosen at the
	 *            time of the exception (for example, if multipart resolution
	 *            failed)
	 * @param ex
	 *            the exception that got thrown during handler execution
	 * @return a corresponding ModelAndView to forward to, or {@code null} for
	 *         default processing
	 */
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		// Expose ModelAndView for chosen error view.
		String viewName = determineViewName(ex, request);
		if (viewName != null) {
			// Apply HTTP status code for error views, if specified.
			// Only apply it if we're processing a top-level request.
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			ModelAndView mv=	 getModelAndView(viewName, ex, request);
			
			String siteurl = "siteurl";
			if(url!=null){
				siteurl=url;
			}else{
				siteurl="http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath()+"/";
			}
			logger.info("url:"+ url);
			mv.addObject("siteurl", siteurl);
			mv.addObject("sitename", "openyelp");
			return mv;
		} else {
			return null;
		}
	}
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
