package com.mayab.calidad.doubles.tareaUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAccountParametrized.class, TestAlerts.class, TestTransactions.class })
public class AllTests {

}
