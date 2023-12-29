package com.nbsaas.life;

import com.nbsaas.boot.generator.GeneratorApp;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.beans.FormBeanConvert;
import com.nbsaas.boot.generator.command.common.*;
import com.nbsaas.boot.generator.command.jpa.RepositoryCommand;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.life.command.ControllerShopCommand;
import com.nbsaas.life.command.MapperPackageCommand;
import com.nbsaas.life.command.MapperXmlCommand;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        makeCodes("config/shop.yml");
        makeCodes("config/area.yml");
        makeCodes("config/talk.yml");
        makeCodes("config/ad.yml");
        makeCodes("config/product.yml");
        makeCodes("config/customer.yml");
        makeCodes("config/promote.yml");
        makeCodes("config/common.yml");
        makeCodes("config/order.yml");


    }

    private static void makeCodes(String configFile) throws IOException, SQLException, ClassNotFoundException {
        Yaml yaml = new Yaml();
        String baseFile = GeneratorApp.class.getClassLoader().getResource("").getFile();
        File f = new File(baseFile + configFile);
        //读入文件

        Config config = yaml.loadAs(Files.newInputStream(f.toPath()), Config.class);
        config.setBase(baseFile);

        List<String> tables = config.getEntities();
        if (tables == null) {
            return;
        }
        for (String table : tables) {

            FormBean formBean = new FormBeanConvert().convertClass(Class.forName(config.getEntityPackage() + "." + table));

            InputRequestObject context = new InputRequestObject();
            context.setConfig(config);
            context.setFormBean(formBean);

            new DomainCommand()
                    .after(new ApiCommand())
                    .after(new ConvertCommand())
                    .after(new ControllerAdminCommand())
                    .after(new ControllerFront2Command())
                    .after(new RestCommand())
                    .after(new ExtApiCommand())
                    .after(new RepositoryCommand())
                    .after(new ExtResourceCommand())
                    .after(new MapperXmlCommand())
                    .after(new MapperPackageCommand())
                    .after(new ControllerShopCommand())
                    .after(new FieldCommand())
                    .after(new FinishCommand()).execute(context);
        }
    }
}
