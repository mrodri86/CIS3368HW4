package com.hearthstone.Homework4.Controllers;

import com.hearthstone.Homework4.Models.Love;
import com.hearthstone.Homework4.Models.LoveRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    LoveRepo loveRepo;

    @RequestMapping(value = "/getlovepercentage", method = RequestMethod.GET)
    public ModelAndView getlovepercentage(@RequestParam("firstname") String firstname, @RequestParam("secondname") String secondname) {
        ModelAndView mv = new ModelAndView("dataview");

        String newURL = "https://love-calculator.p.rapidapi.com/getPercentage?fname=" + firstname + "&sname=" + secondname;
        String apikey = "fb33f5fdd6mshf121e9fa13ce817p1f41f7jsnbec1361298f7";
        String fname = "";
        String sname = "";
        String percentage = "";
        String result = "";

        try {
            URL url = new URL(newURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-rapidapi-host", "love-calculator.p.rapidapi.com");
            connection.setRequestProperty("x-rapidapi-key", apikey);
            connection.connect();
            BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                json.append(line);
            }
            JSONObject obj = new JSONObject(json.toString());

            fname = obj.getString("fname");
            sname = obj.getString("sname");
            percentage = obj.getString("percentage");
            result = obj.getString("result");

            mv.addObject("fname", fname);
            mv.addObject("sname", sname);
            mv.addObject("percentage", percentage);
            mv.addObject("result", result);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("id") String id, @RequestParam("firstname") String firstname, @RequestParam("secondname") String secondname, @RequestParam("lovepercentage") String lovepercentage, @RequestParam("loveresult") String loveresult) {
        ModelAndView mv = new ModelAndView("dataview");
        Love personToSave ;
        if(!id.isEmpty())
        {
            Optional<Love> users = loveRepo.findById(id);
            personToSave = users.get();
        }
        else
        {
            personToSave = new Love();
            personToSave.setId(UUID.randomUUID().toString());
        }
        personToSave.setFname(firstname);
        personToSave.setSname(secondname);
        personToSave.setPercentage(lovepercentage);
        personToSave.setResult(loveresult);
        loveRepo.save(personToSave);
        mv.addObject("lovelist", loveRepo.findAll());
        return mv;
    }

    @RequestMapping("/load")
        public ModelAndView load() {
        ModelAndView mv = new ModelAndView("load");
        mv.addObject("lovelist", loveRepo.findAll());
        return mv;
    }
}
