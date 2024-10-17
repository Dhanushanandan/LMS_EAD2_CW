package cw.lms_ead.Services;


import cw.lms_ead.Entities.Membership;
import cw.lms_ead.dto.MembershipDTO;
import cw.lms_ead.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembershipServices {

    @Autowired
    private MembershipRepository membershipRepository;


    //insert membership
    public MembershipDTO  addMembership(MembershipDTO membershipDTO) {
        Membership membership = new Membership();
        membership.setId(membershipDTO.getId());
        membership.setM_id(membershipDTO.getM_id());
        membership.setMembership_end(membershipDTO.getMembership_end());
        membershipRepository.save(membership);
        return membershipDTO;
    }

    //select all the memberships
    public List<MembershipDTO> getAllMemberships() {
        List<Membership> memberships = membershipRepository.findAll();
        List<MembershipDTO> membershipDTOs = new ArrayList<MembershipDTO>();
        for (Membership membership : memberships) {
            MembershipDTO membershipDTO = new MembershipDTO();
            membershipDTO.setId(membership.getId());
            membershipDTO.setM_id(membership.getM_id());
            membershipDTO.setMembership_end(membership.getMembership_end());
            membershipDTOs.add(membershipDTO);

        }
        return membershipDTOs;
    }

    //update membership
    public MembershipDTO updateMembership(String Id,MembershipDTO membershipDTO) {
        Membership membership = membershipRepository.findById(Id).orElse(new Membership());
        membership.setId(membershipDTO.getId());
        membership.setM_id(membershipDTO.getM_id());
        membership.setMembership_end(membershipDTO.getMembership_end());
        membershipRepository.save(membership);
        return membershipDTO;
    }

    ///delete a membership
    public void deleteMembership(String Id) {
        membershipRepository.deleteById(Id);
    }

    //select one membership
    public MembershipDTO getMembership(String Id) {
        Membership membership = membershipRepository.findById(Id).orElse(new Membership());
        MembershipDTO membershipDTO = new MembershipDTO();
        membershipDTO.setId(membership.getId());
        membershipDTO.setM_id(membership.getM_id());
        membershipDTO.setMembership_end(membership.getMembership_end());
        return membershipDTO;
    }
}
