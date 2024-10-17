package cw.lms_ead.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class MembershipDTO {

        private String id;
        private String m_id;
        private String membership_end;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getM_id() {
            return m_id;
        }

        public void setM_id(String m_id) {
            this.m_id = m_id;
        }

        public String getMembership_end() {
            return membership_end;
        }

        public void setMembership_end(String membership_end) {
            this.membership_end = membership_end;
        }

}
