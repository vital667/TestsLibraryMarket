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
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells.services.Library;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells.UserInput;

/**
 * Responsible for get proper template after request
 */
@Controller
public class LibraryController {

    /**
     * Service declaration
     */
    @Autowired private Library library;

    /**
     * Method get template with exercise
     * @param model stored writers and articles
     * @return template with exercise to fill
     */
    @GetMapping("/lib") public String getLib(Model model){
        model.addAttribute("writers", library.showWriters());
        model.addAttribute("articles", library.showArticles());
        model.addAttribute("userInput", new UserInput());
        return "lib";
    }

    /**
     * Method calculate generated model of library
     * @param userInput holding user input
     * @param model stored writers and articles
     * @return template fulfilled by result
     */
    @PostMapping("/lib") public String postLibrary(@ModelAttribute UserInput userInput, Model model){
        model.addAttribute("writers", library.showWriters());
        model.addAttribute("articles", library.showArticles());
        model.addAttribute("result", library.generateResult(userInput.getInput()));
       return "lib";
    }
}
