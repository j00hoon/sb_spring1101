package academy.learnprogramming;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Random;


// @Getter    Getter annotation을 붙이고,
// Reason why we don't annotate to the interface : Want to make the interface dependent on spring. Interface supposed to be decoupled from the implementation
@Component
public class NumberGeneratorImp implements NumberGenerator
{

    // @Getter(AccessLevel.NONE) random 은 AccessLevel.NONE 선언을 해준다. 2번째 방법.
    // fields
    private final Random random = new Random();

    // 각자의 field에 Getter를 붙이는 것이 1번째 방법.
    @Getter
    private final int maxNumber;
    @Getter
    private final int minNumber;

    // constructor
    @Autowired
    public NumberGeneratorImp(@MaxNumber int maxNumber, @MinNumber int minNumber)
    {
       this.maxNumber = maxNumber;
       this.minNumber = minNumber;
    }

    // public methods
    @Override
    public int next()
    {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

//    @Override
//    public int getMaxNumber()
//    {
//        return maxNumber;
//    }
//
//    @Override
//    public int getMinNumber()
//    {
//        return minNumber;
//    }

}
