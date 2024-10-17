package cw.lms_ead.Services;


import cw.lms_ead.Entities.Member;
import cw.lms_ead.dto.MemberDTO;
import cw.lms_ead.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServices {

    @Autowired
    private MemberRepository memberRepository;

    //insert a book
    public MemberDTO addMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setPhone(memberDTO.getPhone());
        memberRepository.save(member);
        return memberDTO;
    }

    //select all members
    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberDTO> memberDTOs = new ArrayList<MemberDTO>();
        for (Member member : members) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setId(member.getId());
            memberDTO.setName(member.getName());
            memberDTO.setEmail(member.getEmail());
            memberDTO.setPhone(member.getPhone());
            memberDTOs.add(memberDTO);

        }
        return memberDTOs;
    }


    //update members
    public MemberDTO updateMember(String Id,MemberDTO memberDTO) {
        Member member = memberRepository.findById(Id).orElse(new Member());
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setPhone(memberDTO.getPhone());
        memberRepository.save(member);
        return memberDTO;
    }

    //delete member
    public void deleteMember(String Id) {
        memberRepository.deleteById(Id);
    }

    // select single member
    public MemberDTO getMember(String Id) {
        Member member = memberRepository.findById(Id).orElse(new Member());
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setName(member.getName());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPhone(member.getPhone());
        return memberDTO;
    }
}
