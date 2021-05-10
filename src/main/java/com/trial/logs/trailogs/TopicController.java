package com.trial.logs.trailogs;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    List<Topic> topics =Arrays.asList(
            new Topic("1","movies","jathi rathnalu"),
            new Topic("2","songs","chitti"),
            new Topic("3","walking","distance,time,location"));

    @RequestMapping("/topics")
    public List<Topic> getAllTopics()
    {
        System.out.println("testing push in Github!!");
        return Arrays.asList(

                new Topic("1","movies","jathi rathnalu"),
                new Topic("2","songs","chitti"),
                new Topic("3","walking","distance,time,location")

        );
    }

    /*@RequestMapping("/topics/{id}")
    public List<Topic> getTopicId(@PathVariable String id)
    {
        Topic topic = topics.get(id);

    }*/
}
