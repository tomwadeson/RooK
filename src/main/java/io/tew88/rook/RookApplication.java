package io.tew88.rook;

import io.tew88.rook.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RookApplication extends Application<RookConfiguration>{
    
    public static void main(String[] args) throws Exception {
        new RookApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<RookConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<RookConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(RookConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(RookConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new UserResource());
    }
}