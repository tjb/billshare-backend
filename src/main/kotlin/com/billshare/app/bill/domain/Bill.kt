package com.billshare.app.bill.domain

import com.billshare.app.access.user.domain.User
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Bills")
data class Bill (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        val id: Long? = null,

        @Column(name = "price")
        val price: Double? = null,

        @Column(name = "name")
        val name: String? = null,

        @Column(name = "dueDate")
        @Temporal(TemporalType.TIMESTAMP)
        val dueDate: Date? = null,

        @ManyToOne
        @JoinColumn(name = "userId")
        var user: User? = null,

        @OneToMany(mappedBy = "bill", cascade = arrayOf(CascadeType.ALL))
        var users: Set<UserBill> = emptySet()
) {
        override fun toString(): String {
                return ""
        }
}
