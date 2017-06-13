package com.martinrist.hibernate.caveatEmptor.converter;

import com.martinrist.hibernate.caveatEmptor.domain.GermanZipCode;
import com.martinrist.hibernate.caveatEmptor.domain.SwissZipCode;
import com.martinrist.hibernate.caveatEmptor.domain.ZipCode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ZipcodeConverter implements AttributeConverter<ZipCode, String> {

    @Override
    public String convertToDatabaseColumn(ZipCode attribute) {

        return (attribute == null ? "" : attribute.getValue());
    }

    @Override
    public ZipCode convertToEntityAttribute(String dbData) {

        if (dbData == null || dbData.isEmpty()) return null;

        if (dbData.length() == 5) {
            return new GermanZipCode(dbData);
        } else if (dbData.length() == 4) {
            return new SwissZipCode(dbData);
        }

        throw new IllegalArgumentException("Unsupported zip code in database: " + dbData);

    }
}
