package com.nbsaas.life.system.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.life.system.api.apis.RoleApi;
import com.nbsaas.life.system.api.apis.RoleMenuApi;
import com.nbsaas.life.system.api.domain.field.RoleMenuField;
import com.nbsaas.life.system.api.domain.request.RoleMenuDataRequest;
import com.nbsaas.life.system.api.domain.response.RoleResponse;
import com.nbsaas.life.system.api.domain.simple.MenuSimple;
import com.nbsaas.life.system.api.domain.simple.RoleMenuSimple;
import com.nbsaas.life.system.data.entity.Menu;
import com.nbsaas.life.system.data.mapper.MenuMapper;
import com.nbsaas.life.system.data.repository.MenuRepository;
import com.nbsaas.life.system.ext.apis.MenuExtApi;
import com.nbsaas.life.system.ext.domain.request.UpdateRoleMenuRequest;
import com.nbsaas.life.system.ext.domain.simple.MenuExtSimple;
import com.nbsaas.life.system.rest.convert.MenuSimpleConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class MenuExtResource implements MenuExtApi {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private RoleMenuApi roleMenuApi;

    @Resource
    private RoleApi roleApi;


    @Transactional(readOnly = true)
    @Override
    public ListResponse<MenuExtSimple> tree(Long userId) {
        ListResponse<MenuExtSimple> result = new ListResponse<>();

        List<MenuSimple> list = menuMapper.findByUser(userId);
        if (list != null) {
            result.setData(makeTree(list));
        }
        return result;
    }

    @Override
    public ListResponse<MenuExtSimple> root() {
        ListResponse<MenuExtSimple> result = new ListResponse<>();
        List<Menu> all = menuRepository.findAll();
        List<MenuSimple> list = all.stream().map(new MenuSimpleConvert()).collect(Collectors.toList());
        result.setData(makeTree(list));
        return result;
    }

    @Override
    public ListResponse<MenuExtSimple> findByRole(Long role) {
        return null;
    }

    @Override
    public ListResponse<Long> selectForPermission(Long role) {
        ListResponse<Long> result = new ListResponse<Long>();
        List<RoleMenuSimple> roles = roleMenuApi.listData(Filter.eq(RoleMenuField.role, role));
        if (roles != null) {
            result.setData(roles.stream().map(RoleMenuSimple::getMenu).collect(Collectors.toList()));
        }
        return result;
    }

    @Override
    public ListResponse<String> selectPermissionByUser(Long userId) {
        return null;
    }

    @Override
    public ResponseObject<?> updateRoleMenus(UpdateRoleMenuRequest request) {
        ResponseObject<?> result = new ResponseObject<>();
        RoleResponse role = roleApi.oneData(Filter.eq("id", request.getRoleId()));
        if (role == null) {
            result.setCode(501);
            result.setMsg("无效校色id");
            return result;
        }
        roleMenuApi.deleteByFilter(Filter.eq(RoleMenuField.role, request.getRoleId()));

        for (Long menu : request.getMenus()) {
            RoleMenuDataRequest form = new RoleMenuDataRequest();
            form.setRole(request.getRoleId());
            form.setMenu(menu);
            roleMenuApi.createData(form);
        }

        return result;
    }

    private List<MenuExtSimple> makeTree(List<MenuSimple> menuList) {
        List<MenuExtSimple> tree = new ArrayList<>();
        if (menuList != null && menuList.size() > 0) {
            List<MenuExtSimple> ls = menuList.stream().map(item -> {
                MenuExtSimple simple = new MenuExtSimple();
                BeanUtils.copyProperties(item, simple);
                if (simple.getSortNum()==null){
                    simple.setSortNum(0);
                }
                return simple;
            }).collect(Collectors.toList());
            Map<Long, MenuExtSimple> map = new HashMap<>();
            for (MenuExtSimple item : ls) {
                map.put(item.getId(), item);
            }
            for (MenuExtSimple item : ls) {
                if (item.getParent() == null) {
                    tree.add(item);
                } else {
                    MenuExtSimple parent = map.get(item.getParent());
                    if (parent != null) {
                        if (parent.getChildren() == null) {
                            parent.setChildren(new ArrayList<>());
                        }
                        parent.getChildren().add(item);
                    }
                }
            }

        }
        tree.sort(Comparator.comparingLong(MenuExtSimple::getSortNum));
        return tree;
    }
}
