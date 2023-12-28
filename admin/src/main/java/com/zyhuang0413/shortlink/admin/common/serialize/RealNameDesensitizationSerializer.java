package com.zyhuang0413.shortlink.admin.common.serialize;

import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author zyhuang
 * Date: 2023/12/27
 * Time: 2:23
 * Description: 用户真实姓名脱敏序列化
 */
public class RealNameDesensitizationSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String realName, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String realNameDesensitization = DesensitizedUtil.chineseName(realName);
        jsonGenerator.writeString(realNameDesensitization);
    }

}
