package com.example.store.config;


import graphql.schema.GraphQLScalarType;
import graphql.scalars.ExtendedScalars;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class GraphQlConfig {

//        @Bean
//        public RuntimeWiringConfigurer runtimeWiringConfigurer() {
//            return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.GraphQLLong);
//        }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .scalar(ExtendedScalars.GraphQLLong)
                .scalar(localTimeScalar())
                .scalar(voidScalar());

    }

    @Bean
    public GraphQLScalarType localTimeScalar() {
        return GraphQLScalarType.newScalar()
                .name("LocalTime")
                .description("A custom scalar that handles LocalTime")
                .coercing(new Coercing<LocalTime, String>() {
                    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;

                    @Override
                    public String serialize(Object dataFetcherResult) {
                        if (dataFetcherResult instanceof LocalTime) {
                            return formatter.format((LocalTime) dataFetcherResult);
                        }
                        throw new CoercingSerializeException("Expected a LocalTime object.");
                    }

                    @Override
                    public LocalTime parseValue(Object input) {
                        try {
                            return LocalTime.parse(input.toString(), formatter);
                        } catch (Exception e) {
                            throw new CoercingParseValueException("Invalid value for LocalTime: " + input, e);
                        }
                    }

                    @Override
                    public LocalTime parseLiteral(Object input) {
                        try {
                            return LocalTime.parse(input.toString(), formatter);
                        } catch (Exception e) {
                            throw new CoercingParseLiteralException("Invalid literal for LocalTime: " + input, e);
                        }
                    }
                })
                .build();
    }

    @Bean
    public GraphQLScalarType voidScalar() {
        return GraphQLScalarType.newScalar()
                .name("Void")
                .description("A custom scalar that represents a void return type")
                .coercing(new Coercing<Object, Void>() {
                    @Override
                    public Void serialize(Object dataFetcherResult) {
                        return null;
                    }

                    @Override
                    public Void parseValue(Object input) {
                        return null;
                    }

                    @Override
                    public Void parseLiteral(Object input) {
                        return null;
                    }
                })
                .build();
    }
}
