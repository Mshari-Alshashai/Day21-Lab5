package com.example.lab5q3.Controller;

import com.example.lab5q3.ApiResponse.ApiResponse;
import com.example.lab5q3.Module.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("event added");
    }

    @GetMapping("/display")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new ApiResponse("event updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("event deleted");
    }

    @PutMapping("/change-capacity/{index}")
    public ApiResponse changeCapacity(@PathVariable int index,@RequestParam int newCapacity) {
        events.get(index).setCapacity(newCapacity);
        return new ApiResponse("event capacity updated");
    }

    @GetMapping("/search/{index}")
    public Event getEventById(@PathVariable int index) {
        return events.get(index+1);
    }

}
