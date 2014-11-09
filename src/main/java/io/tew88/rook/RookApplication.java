package io.tew88.rook;

import org.skife.jdbi.v2.DBI;

import io.tew88.rook.domain.dao.UserDao;
import io.tew88.rook.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
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
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        
        environment.jersey().register(new UserResource(jdbi.onDemand(UserDao.class)));
    }
}