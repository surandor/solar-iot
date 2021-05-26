package com.phynos.solar.codec.product;

import com.phynos.solar.codec.device.IotAtrribute;
import com.phynos.solar.codec.device.IotEvent;
import com.phynos.solar.codec.device.IotService;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
public class DefaultIotProduct implements IotProduct {

    private String code;

    private String version;

    private String vendor;

    private Map<String, IotAtrribute> attrs;

    private Map<String, IotEvent> events;

    private Map<String, IotService> services;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getVendor() {
        return vendor;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Map<String, IotAtrribute> getAttrs() {
        return attrs;
    }

    @Override
    public Map<String, IotEvent> getEvents() {
        return events;
    }

    @Override
    public Map<String, IotService> getServices() {
        return services;
    }

}
