package com.ada.iyelp.apps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.ada.iyelp.factory.ZHUtils;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.quhaodian.data.entity.ShopCategory;
import com.quhaodian.data.service.ShopCategoryService;

public class ShopCategoryServiceApps {

    public static void main(String[] args) throws FileNotFoundException {

        JsonParser parser = new JsonParser();
        String file=ShopCategoryServiceApps.class.getResource("/catalogs.json").getFile();
        System.out.println(""+file);
        JsonElement element = parser.parse(new FileReader(new File(file)));
        JsonArray array=  element.getAsJsonArray();
        ShopCategory category=new ShopCategory();
        category.setId(1);
        works(array,category);
        // TODO Auto-generated method stub

//		Long time=System.currentTimeMillis();
//		List<ShopCatalog> cs=	userService.findByPidl2(1);
//		for (ShopCatalog shopCatalog : cs) {
//			//System.out.println(shopCatalog);
//		}
//		time=System.currentTimeMillis()-time;
//		System.out.println(time);

        //System.out.println(userService.updateNumsAndTime(114));

        String str = "你好世界";
        PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_MARK); // nǐ,hǎo,shì,jiè
        PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_NUMBER); // ni3,hao3,shi4,jie4
        PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITHOUT_TONE); // ni,hao,shi,jie
        PinyinHelper.getShortPinyin(str); // nhsj
    }

    private static void works(JsonArray array,ShopCategory parent) {
        for (int i = 0; i <array.size() ; i++) {
            JsonElement item=  array.get(i);
           String englishname= item.getAsJsonObject().get("a").getAsString();
            String chinesename= item.getAsJsonObject().get("t").getAsString();
            JsonArray childs=  item.getAsJsonObject().get("c").getAsJsonArray();

            ShopCategory category=new ShopCategory();
            category.setName(englishname);
            category.setCname(ZHUtils.convert2Simplified(chinesename));
            category.setParent(parent);
            category.setPy(PinyinHelper.getShortPinyin(category.getCname()));
            category.setPinyin(PinyinHelper.convertToPinyinString(category.getCname(), ",", PinyinFormat.WITH_TONE_NUMBER));
            ShopCategoryService userService = ObjectFactory.get().getBean(
                    ShopCategoryService.class);
            userService.save(category);
            if (childs.size()>0){
                System.out.println("*********");
                //
                works(childs,category);
            }
            System.out.println(englishname+"****"+ ZHUtils.convert2Simplified(chinesename));
        }
    }
    private static void works2(JsonArray array,JsonElement parent) {
        for (int i = 0; i <array.size() ; i++) {
            JsonElement item=  array.get(i);
            String englishname= item.getAsJsonObject().get("a").getAsString();
            String chinesename= item.getAsJsonObject().get("t").getAsString();
            JsonArray childs=  item.getAsJsonObject().get("c").getAsJsonArray();
            if (childs.size()>0){
                System.out.println("*********");
                works2(childs,item);
            }
            System.out.println(englishname+"****"+ ZHUtils.convert2Simplified(chinesename));
        }
    }
    private static void s() {
        ShopCategoryService userService = ObjectFactory.get().getBean(
                ShopCategoryService.class);
        ShopCategory m = new ShopCategory();
        m.setName("商家分类");
//		userService.save(m);
        List<ShopCategory> cs = userService.findByTops(537);
        for (ShopCategory shopCategory : cs) {
            System.out.println(shopCategory.getCname());
        }
//		m=userService.findById(1l);
//		System.out.println(m.getRoles());
//		RoleService roleService= ObjectFactory.get().getBean(
//				RoleService.class);
//		Role bean=new Role("admin");
//		bean.setDescription("adminer");
//		bean.setId(2l);
        //roleService.save(bean);
        //userService.addRole(m.getId(), bean);
    }

}
