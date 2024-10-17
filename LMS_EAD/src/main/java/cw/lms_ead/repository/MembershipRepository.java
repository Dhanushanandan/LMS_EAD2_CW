package cw.lms_ead.repository;

import cw.lms_ead.Entities.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, String> {
}
