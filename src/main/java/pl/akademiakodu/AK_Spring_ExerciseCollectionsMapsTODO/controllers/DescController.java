package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.controllers;

/**
 * Imports section
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Responsible for get proper template after request
 */
@Controller
public class DescController {

    /**
     * Method get description as a template
     * @return template with description
     */
    @GetMapping("/desc") public String descGet(){
        return "desc";
    }
}
