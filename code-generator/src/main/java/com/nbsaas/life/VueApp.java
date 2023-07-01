package com.nbsaas.life;

import com.nbsaas.boot.generator.GeneratorApp;
import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.beans.FormBeanConvert;
import com.nbsaas.boot.generator.command.common.FinishCommand;
import com.nbsaas.boot.generator.command.vue3.VueCommand;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

public class VueApp {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        makeCodes("vue/area.yml");


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

            new VueCommand()
                    .after(new FinishCommand()).execute(context);
        }
    }
}
