package cw.lms_ead.controllers;

import cw.lms_ead.Services.MembershipServices;
import cw.lms_ead.dto.BookDTO;
import cw.lms_ead.dto.MembershipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/LMS/Membership")

public class MembershipController {

    @Autowired
    private MembershipServices membershipServices;

    @GetMapping
    public List<MembershipDTO> getAllMemberships() {

        try {
            return membershipServices.getAllMemberships();
        }catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @PostMapping
    public Map<String, Object> addMembership(@RequestBody MembershipDTO membershipDTO) {
//        return membershipServices.addMembership(membershipDTO);
        Map<String, Object> response = new HashMap<>();
        try {
            MembershipDTO newMembership = membershipServices.addMembership(membershipDTO);
            response.put("message", "Membership added complete");
            response.put("Membership", newMembership);
        }catch(Exception e) {
            System.out.println(e);
            response.put("message", "Membership not added");

        }
        return response;
    }

    @PutMapping("/{Id}")
    public Map<String, Object> updateMembership(@PathVariable String Id, @RequestBody MembershipDTO membershipDTO) {
//        return membershipServices.updateMembership(Id, membershipDTO);
        Map<String, Object> response = new HashMap<>();
        try {
            MembershipDTO newMembership = membershipServices.updateMembership(Id, membershipDTO);
            response.put("message", "Membership updated complete");
            response.put("Membership", newMembership);
        }catch(Exception e) {
            System.out.println(e);
            response.put("message", "Membership not Updated");
        }
        return response;
    }

    @DeleteMapping("/{Id}")
    public String deleteMembership(@PathVariable String Id) {
//
//        return "Deleted Membership";
        try {
            membershipServices.deleteMembership(Id);
            return "Membership deleted";
        }catch(Exception e) {
            System.out.println(e);
            return "Membership not Deleted";
        }
    }

    @GetMapping("/{Id}")
    public MembershipDTO getMembership(@PathVariable String Id) {
//
        try {
            return membershipServices.getMembership(Id);
        }catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
