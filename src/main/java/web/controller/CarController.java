package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    // Создайте список из 5 машин.
    private List<Car> carList = Arrays.asList(
            new Car("f1", "f2", "f3"),
            new Car("f21", "f22", "f23"),
            new Car("f31", "f32", "f33"),
            new Car("f41", "f42", "f43"),
            new Car("f51", "f52", "f53")
    );

    @GetMapping("")
    public String handle(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count,
                         ModelMap model) {
        System.out.println("handle: <- count=" + count + ", model=" + model);

        // При запросе /cars?count=2 должен отобразиться список из 2 машин,
        // при /cars?count=3 - из 3, и тд. При count ≥ 5 выводить весь список машин.
        List<Car> cars = new ArrayList<>();
        for (int i=0; i < Math.min(count, carList.size()); i++) {
            cars.add(carList.get(i));
        }

        model.addAttribute("cars", cars);
        System.out.println("handle: ->");
        return "cars";
    }
}
