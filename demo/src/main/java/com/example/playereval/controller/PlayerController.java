package com.example.playereval.controller;

import com.example.playereval.dto.PlayerFormDTO;
import com.example.playereval.entity.Player;
import com.example.playereval.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;
    
    @GetMapping("/")
    public String showPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "index";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        PlayerFormDTO dto = new PlayerFormDTO();
        model.addAttribute("player", dto);
        model.addAttribute("indexers", playerService.getAllIndexers());
        return "player-form";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Player> playerOpt = playerService.getPlayerById(id);
        if (playerOpt.isPresent()) {
            Player player = playerOpt.get();
            PlayerFormDTO dto = new PlayerFormDTO();
            dto.setPlayerId(player.getPlayerId());
            dto.setName(player.getName());
            dto.setFullName(player.getFullName());
            dto.setAge(player.getAge());
            
            // 填充指标值
            HashMap<String, Float> indexValues = new HashMap<>();
            player.getPlayerIndices().forEach(pi -> {
                indexValues.put(pi.getIndexer().getName(), pi.getValue());
            });
            dto.setIndexValues(indexValues);
            
            model.addAttribute("player", dto);
            model.addAttribute("indexers", playerService.getAllIndexers());
            return "player-form";
        }
        return "redirect:/";
    }
    
    @PostMapping("/save")
    public String savePlayer(@Valid @ModelAttribute("player") PlayerFormDTO player, 
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("indexers", playerService.getAllIndexers());
            return "player-form";
        }
        
        // 自定义验证
        if (player.getAge() == null || player.getAge().isEmpty()) {
            result.rejectValue("age", "error.age", "Age is required");
            model.addAttribute("indexers", playerService.getAllIndexers());
            return "player-form";
        }
        
        playerService.savePlayer(player);
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable("id") Integer id) {
        playerService.deletePlayer(id);
        return "redirect:/";
    }
}