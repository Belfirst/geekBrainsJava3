import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekBrains.WorkingWithArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestArrays {
    WorkingWithArrays wwa;

    @BeforeEach
    public void init(){
        wwa = new WorkingWithArrays();
    }

    @ParameterizedTest
    @MethodSource("testShouldReturnArray")
    public void testShouldReturnArray(int[] result, int[] array){
        Assertions.assertArrayEquals(result, wwa.getAllAfterFour(array));
    }

    public static Stream<Arguments> testShouldReturnArray(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{5}, new int[] {1,2,3,4,5}));
        out.add(Arguments.arguments(new int[]{3,2,1}, new int[] {5,4,3,2,1}));
        out.add(Arguments.arguments(new int[]{30,59}, new int[] {5,4,8,3,7,1,4,18,50,4,30,59}));
        out.add(Arguments.arguments(new int[]{}, new int[] {4,4,4,4,4,4,4,4}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("withoutFourShouldThrowException")
    public void withoutFourShouldThrowException(int[] array){
        Assertions.assertThrows(ArithmeticException.class, () -> wwa.getAllAfterFour(array));
    }

    public static Stream<int[]> withoutFourShouldThrowException(){
        List<int[]> out = new ArrayList<>();
        out.add(new int[]{});
        out.add(new int[]{1,2,3,6,7});
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("ifArrayWithOnlyOneAndFourShouldReturnTrue")
    public void ifArrayWithOnlyOneAndFourShouldReturnTrue(int[] array){
        Assertions.assertTrue(wwa.checkArray(array));
    }

    public static Stream<int[]> ifArrayWithOnlyOneAndFourShouldReturnTrue(){
        List<int[]> out = new ArrayList<>();
        out.add(new int[]{1,1,1,4,4,1,4,4});
        out.add(new int[]{1,4,4,4,4,4,4,4});
        out.add(new int[]{1,1,1,1,4});
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("ifArrayWithoutOneOrFourShouldReturnFalse")
    public void ifArrayWithoutOneOrFourShouldReturnFalse(int[] array){
        Assertions.assertFalse(wwa.checkArray(array));
    }
    public static Stream<int[]> ifArrayWithoutOneOrFourShouldReturnFalse(){
        List<int[]> out = new ArrayList<>();
        out.add(new int[]{1,1,1,1,1});
        out.add(new int[]{4,4,4,4,4,4});
        out.add(new int[]{1,1,1,4,4,1,4,3});
        return out.stream();
    }
}
