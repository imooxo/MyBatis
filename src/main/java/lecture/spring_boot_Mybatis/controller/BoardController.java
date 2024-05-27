package lecture.spring_boot_Mybatis.controller;

import lecture.spring_boot_Mybatis.dto.BoardCreateDTO;
import lecture.spring_boot_Mybatis.dto.BoardDTO;
import lecture.spring_boot_Mybatis.dto.DefaultResDTO;
import lecture.spring_boot_Mybatis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public String boards(Model model){
        List<BoardDTO> boards = boardService.getBoards();
        model.addAttribute("boards", boards);
        return "board";
    }

    @PostMapping("")
    @ResponseBody
    public Map<String, Boolean> insertBoard(
            @RequestBody BoardCreateDTO board
            ) {
        //Map<String,Boolean> result = new HashMap<>();
        boolean result = false;
        String errMsg = null;
        try{
            // insert service method
            boardService.insertBoard(board);
            result = true;
        }catch (Exception e){
            errMsg = e.getMessage();
            log.error("insert board err {}", e.getMessage());
        }
        return DefaultResDTO.builder()
                .result(result)
                .errMsg(errMsg)
                .build();
    }

    @PostMapping("/{id}")
    @ResponseBody
    public DefaultResDTO updateBoard(
            @RequestBody BoardCreateDTO board
    ){
        DefaultResDTO res = new DefaultResDTO();
        try{
            boardService.insertBoard(id, board);

        }catch (Exception e){
            res.setResult(false);
            res.setErrMsg(e.getMessage());
            log.error("insert board err{}", e.getMessage());
        }
    }
}//class
