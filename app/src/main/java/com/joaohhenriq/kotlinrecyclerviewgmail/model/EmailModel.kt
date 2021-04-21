package com.joaohhenriq.kotlinrecyclerviewgmail.model

data class EmailModel (
    val user: String,
    val subject: String,
    val preview: String,
    val date: String,
    val stared: Boolean,
    val unread: Boolean,
    var selected: Boolean = false
)

class EmailBuilder {
    var user: String = ""
    var subject: String = ""
    var preview: String = ""
    var date: String = ""
    var stared: Boolean = false
    var unread: Boolean = false

    fun build(): EmailModel = EmailModel(user, subject, preview, date, stared, unread, false)
}

fun email(block: EmailBuilder.() -> Unit): EmailModel = EmailBuilder().apply(block).build()

fun fakeEmails(): MutableList<EmailModel> = mutableListOf(
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = false
        unread = true
    },
    email {
        user = "Youtube"
        subject = "Bem vindo ao Youtube, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = false
        unread = true
    },email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = true
        unread = false
    },
    email {
        user = "PicPay"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = true
        unread = false
    },
    email {
        user = "Tinder"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = false
        unread = false
    },
    email {
        user = "iFood"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = true
        unread = false
    },
    email {
        user = "Instagram"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = false
        unread = false
    },
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = true
        unread = false
    },
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = true
        unread = false
    },
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = false
        unread = false
    },
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = true
        unread = false
    },
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = true
        unread = false
    },
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = false
        unread = false
    },
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = true
        unread = false
    },
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = false
        unread = false
    },email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = false
        unread = false
    },
    email {
        user = "Facebook"
        subject = "Bem vindo ao Facebook, ficamos muito felizes de tê-lo conosco!"
        preview = "Olá olá, você deseja mandar uma mensagem a um amigo?"
        date = "26 jun"
        stared = false
        unread = false
    }
)