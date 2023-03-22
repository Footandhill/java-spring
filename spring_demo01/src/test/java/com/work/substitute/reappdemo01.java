package com.work.substitute;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.work")
@Import(reappdemo02.class)
public class reappdemo01 {



}
