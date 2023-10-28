package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.ErrorMessage;

public class CarGroup {

    private final List<Car> carGroup;

    public CarGroup() {
        this.carGroup = new ArrayList<>();
    }

    public boolean addCar(String name) {
        validateUniqueName(name);
        return carGroup.add(new Car(name));
    }

    private void validateUniqueName(String name) {
        boolean hasDuplicate = carGroup.stream()
                .anyMatch(car -> car.getName().equals(name));
        if (hasDuplicate) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_NOT_UNIQUE.getMessage());
        }
    }

    public int size() {
        return this.carGroup.size();
    }

    public void run(MoveCount moveCount) {
        for (int i = 0; i < moveCount.get(); i++) {
            for (Car car : carGroup) {
                car.run();
            }
        }
    }
}