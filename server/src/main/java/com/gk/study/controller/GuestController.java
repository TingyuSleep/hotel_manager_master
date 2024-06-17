package com.gk.study.controller;

import com.gk.study.common.APIResponse;
import com.gk.study.common.ResponeCode;
import com.gk.study.entity.Guest;
import com.gk.study.service.GuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/guest")
@CrossOrigin(origins = {"*"})
public class GuestController {

    @Autowired
    private GuestService guestService;

    /**
     * 查询住户信息
     *
     * @param keyword
     * @return
     */
    @GetMapping(value = "/list")
    public APIResponse list(String keyword) {
        log.info("开始查询住户信息,参数为{}", keyword);
        List<Guest> list = guestService.getGuestList(keyword);
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }


    /**
     * 新增操作
     *
     * @param guest
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/create")
    @Transactional
    public APIResponse create(Guest guest) throws IOException {
        guest.setEnterTime(String.valueOf(LocalDateTime.now()));
        log.info("新增住户信息，参数为{}",guest);
        guestService.createGuest(guest);
        return new APIResponse(ResponeCode.SUCCESS, "创建成功");
    }
    /**
     * 更新信息操作
     * @param guest
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/update")
    public APIResponse update(Guest guest) throws IOException {
        guest.setEnterTime(String.valueOf(LocalDateTime.now()));
        log.info("新增住户信息，参数为{}",guest);
        guestService.updateGuest(guest);
        return new APIResponse(ResponeCode.SUCCESS, "更新成功");
    }

    /**
     * 删除用户信息操作
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(String ids){
        log.info("删除用户ids==={}", ids);
        // 批量删除
        String[] arr = ids.split(",");
        for (String id : arr) {
            guestService.deleteUser(id);
        }
        return new APIResponse(ResponeCode.SUCCESS, "删除成功");
    }



}
