package br.com.mycompany.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id", nullable = false)
    private Long accountId;

    @Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;

    public AccountEntity(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public AccountEntity() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
