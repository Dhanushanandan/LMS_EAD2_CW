package cw.lms_ead.controllers;


import cw.lms_ead.Entities.Member;
import cw.lms_ead.Services.MemberServices;
import cw.lms_ead.dto.BookDTO;
import cw.lms_ead.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/LMS/Member")
public class MemberController {

    @Autowired
    private MemberServices memberServices;

    @GetMapping
    public List<MemberDTO> getMembers() {

        try {
            return memberServices.getAllMembers();
        }catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @PostMapping
    public Map<String, Object> addMember(@RequestBody MemberDTO memberDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
//            return memberServices.addMember(memberDTO);
            MemberDTO addedMember = memberServices.addMember(memberDTO);

            response.put("message", "member added complete");
            response.put("Member", addedMember);

        }catch(Exception e) {
            System.out.println(e);
            response.put("message", "Member not added");

        }
        return response;


    }

    @PutMapping("/{Id}")
    public Map<String, Object> updateMember(@PathVariable String Id, @RequestBody MemberDTO memberDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            MemberDTO updatedMember = memberServices.updateMember(Id, memberDTO);
            response.put("message", "Member updated complete");
            response.put("Member", updatedMember);
        }catch(Exception e) {
            System.out.println(e);
            response.put("message", "Member not Updated");
        }
        return response;
//        return memberServices.updateMember(Id, memberDTO);
    }

    @DeleteMapping("/{Id}")
    public String deleteMember(@PathVariable String Id) {

//        return "Deleted Member";
        try {
            memberServices.deleteMember(Id);
            return "Member deleted";
        }catch(Exception e) {
            System.out.println(e);
            return "Member not Deleted";
        }
    }

    @GetMapping("/{Id}")
    public MemberDTO getMember(@PathVariable String Id) {

        try {
            return memberServices.getMember(Id);
        }catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
