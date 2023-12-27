package com.nbsaas.life.command;

import com.nbsaas.boot.generator.command.common.BaseCommand;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.context.InputRequestObject;
import com.nbsaas.boot.rest.response.ResponseObject;

/**
 *  店铺控制器生成命令
 */
public class ControllerShopCommand extends BaseCommand {

    public ControllerShopCommand() {
    }

    public ResponseObject handle(InputRequestObject context) {
        this.makeCodePackage("Controller", ".controller." + context.getConfig().getModuleName(), context.getConfig().getBasicPackage());
        return ResponseObject.success();
    }

    public String outPath() {
        Config config = this.inputRequestObject.getConfig();
        return config.getMultiple() ? config.getOutputPath() + "\\gates\\shop" : config.getOutputPath();
    }
}
