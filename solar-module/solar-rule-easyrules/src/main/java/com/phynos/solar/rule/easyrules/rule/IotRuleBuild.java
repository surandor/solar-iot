package com.phynos.solar.rule.easyrules.rule;

import com.phynos.solar.util.json.JsonUtil;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author lupc
 * @date 2021/3/25 16:20
 */
public class IotRuleBuild {

    private String json;

    public IotRuleBuild() {

    }

    public IotRuleBuild fronJson(String path) {
        json = getJson(path);
        return this;
    }

    public IotRule build() {
        IotRule rule = JsonUtil.stringToObject(json, IotRule.class);
        return rule;
    }

    private String getJson(String file) {
        String json = null;
        try (InputStream is = getClass().getResourceAsStream(file)) {
            json = IOUtils.toString(is, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

}