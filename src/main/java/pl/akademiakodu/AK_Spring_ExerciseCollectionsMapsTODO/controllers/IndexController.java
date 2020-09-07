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
public class IndexController {

    /**
     * Method get index as a template
     * @return template with index
     */
    @GetMapping("/") public String indexGet(){
        return "index";
    }

}