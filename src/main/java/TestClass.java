public class TestClass {
    @BeforeSuite
    public static void init(){
        System.out.println("Some initialisation.");
    }

    @Test(priority = 5)
    public static void test5(){
        System.out.println("Test4");
    }

    @Test()
    public static void test7(){
        System.out.println("Test0");
    }

    @Test(priority = 10)
    public static void test1(){
        System.out.println("Test1");
    }

    @Test(priority = 8)
    public static void test8(){
        System.out.println("Test2");
    }

    @Test(priority = 3)
    public static void test3(){
        System.out.println("Test5");
    }

    @Test(priority = 6)
    public static void test6(){
        System.out.println("Test3");
    }

    @AfterSuite
    public static void close(){
        System.out.println("Exit test");
    }
}
