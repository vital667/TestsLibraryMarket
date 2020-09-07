package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.controllers;

/**
 * Imports section
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells.services.Market;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells.UserInput2;

/**
 * Responsible for get proper template after request
 */
@Controller
public class MarketController {

    /**
     * Service declaration
     */
    @Autowired private Market market;

    /**
     * Method get template with exercise
     * @param model stored market items
     * @return template with exercise to fill
     */
    @GetMapping("/mar") public String marketGet(Model model){
        model.addAttribute("availableList", market.showAllItems());
        model.addAttribute("userInput2", new UserInput2());
        return "market";
    }

    /**
     * Method calculate generated costs
     * @param userInput2 holding user input
     * @param model stored market items
     * @return template fulfilled by result
     */
    @PostMapping("/mar") public String marketPost(@ModelAttribute UserInput2 userInput2, Model model){
        if (!userInput2.getInputKey().equals("") && !userInput2.getInputValue().equals("")){
            market.addItem(market.parseEnum(userInput2.getInputKey()), market.parseInt(userInput2.getInputValue()));
        }
        model.addAttribute("shopList", market.showCurrentList());
        model.addAttribute("totalCost", market.calculatePrice());
        model.addAttribute("availableList", market.showAllItems());
        return "market";
    }
}
