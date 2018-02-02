package jtm.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import jtm.activity01.ConfigurationTest;
import jtm.activity02.HelloTest;
import jtm.activity03.ArrayTest;
import jtm.activity03.BlackKnightTest;
import jtm.activity03.RandomPersonTest;
import jtm.activity03.ZodiacTest;
import jtm.activity04.TrafficManagementTest;
import jtm.activity05.EncapsulationTests;
import jtm.activity06.InterfaceTests;
import jtm.activity07.AnimalTests;
import jtm.activity08.SimpleCalcTests;
import jtm.activity09.OrderListTests;
import jtm.activity10.StreamEditorTest;
import jtm.activity11.ArrayFillerManagerTest;
import jtm.activity12.ChatServerTest;
import jtm.activity13.DatabaseTest;
import jtm.activity14.DatabaseUnitTest;
import jtm.activity15.ColorSliderTest;
import jtm.activity16.JettyApplicationTest;
import jtm.extra01.BasicMathFunctionsTest;
import jtm.extra01.GetOneTest;
import jtm.extra01.If_SwitchTest;
import jtm.extra02.ArrayListMethodsTest;
import jtm.extra02.LetsRideTest;
import jtm.extra03.PracticalNumbersTest;
import jtm.extra04.StringTokenizerExerciseTest;
import jtm.extra04.StudentTest;
import jtm.extra05.XMLCarsTest;
import jtm.extra06.GenericsTest;
import jtm.extra06.HolidayTest;
import jtm.extra06.RegExTest;
import jtm.extra07.ChatClientTest;
import jtm.extra08.InvoiceManagerTest;
import jtm.extra09.CrocodileTest;
import jtm.extra09.GameTest;
import jtm.extra10.LogTest;
import jtm.extra13.GitMergeTest;
import jtm.extra14.JNIClassTest;
import jtm.extra16.PersonMatcherTests;

@RunWith(JtmSuite.class)
@SuiteClasses({
		// First week

		ConfigurationTest.class, // 1
		HelloTest.class, // 2
		ArrayTest.class, // 3
		BlackKnightTest.class, // 3
		RandomPersonTest.class, // 3
		ZodiacTest.class, // 3

		TrafficManagementTest.class, // 4
		EncapsulationTests.class, // 5

		InterfaceTests.class, // 6
		AnimalTests.class, // 7
		SimpleCalcTests.class, // 8

		// Second week
		OrderListTests.class, // 9
		StreamEditorTest.class, // 10
		ArrayFillerManagerTest.class, // 11

		ChatServerTest.class, // 12
		DatabaseTest.class, // 13
		DatabaseUnitTest.class, // 14

		ColorSliderTest.class, // 15
		JettyApplicationTest.class, // 16

		// extra activities
		BasicMathFunctionsTest.class, // 1
		GetOneTest.class, // 1
		If_SwitchTest.class, // 1
		ArrayListMethodsTest.class, // 2
		LetsRideTest.class, // 2
		PracticalNumbersTest.class, // 3
		StringTokenizerExerciseTest.class, // 4
		StudentTest.class, // 4
		XMLCarsTest.class, // 5
		GenericsTest.class, // 6
		HolidayTest.class, // 6
		RegExTest.class, // 6
		ChatClientTest.class, // 7
		InvoiceManagerTest.class, // 8
		CrocodileTest.class, // 9
		GameTest.class, // 9
		LogTest.class, // 10
		GitMergeTest.class, // 13
		JNIClassTest.class, // 14
		PersonMatcherTests.class // 16

})
public class AllTests {

}
