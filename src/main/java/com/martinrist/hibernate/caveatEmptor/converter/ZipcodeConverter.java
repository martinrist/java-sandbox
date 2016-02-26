package com.martinrist.hibernate.caveatEmptor.converter;

import com.martinrist.hibernate.caveatEmptor.domain.GermanZipcode;
import com.martinrist.hibernate.caveatEmptor.domain.SwissZipcode;
import com.martinrist.hibernate.caveatEmptor.domain.Zipcode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ZipcodeConverter implements AttributeConverter<Zipcode, String> {

    @Override
    public String convertToDatabaseColumn(Zipcode attribute) {

        return (attribute == null ? "" : attribute.getValue());
    }

    @Override
    public Zipcode convertToEntityAttribute(String dbData) {

        if (dbData == null) return null;

        if (dbData.length() == 5) {
            return new GermanZipcode(dbData);
        } else if (dbData.length() == 4) {
            return new SwissZipcode(dbData);
        }

        throw new IllegalArgumentException("Unsupported zip code in database: " + dbData);

    }
}
