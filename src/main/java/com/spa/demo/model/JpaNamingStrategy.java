package com.spa.demo.model;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class JpaNamingStrategy implements PhysicalNamingStrategy {

    private final static String TBL_PREFIX = "bb_";
    private final static String TBL_SUFFIX = "_tbl";

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name != null) {
            return Identifier.toIdentifier(name.toString().toLowerCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name != null) {
            return Identifier.toIdentifier(name.toString().toLowerCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name != null) {
            return Identifier.toIdentifier(TBL_PREFIX + name.toString().toLowerCase() + TBL_SUFFIX);
        }
        return null;
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name != null) {
            return Identifier.toIdentifier(name.toString().toLowerCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name != null) {
            return Identifier.toIdentifier(name.toString().toLowerCase());
        }
        return null;
    }
}