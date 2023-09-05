package home.amit.exchange.app.exception;
/*
User :- AmitSingh
Date :- 8/20/2023
Time :- 6:37 PM
Year :- 2023
*/

import java.util.function.Predicate;

public class RecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        return !(throwable instanceof BusinessException);
    }
}