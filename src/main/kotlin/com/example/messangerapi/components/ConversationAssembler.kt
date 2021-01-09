package com.example.messangerapi.components

import com.example.messangerapi.helpers.objects.ConversationListVO
import com.example.messangerapi.helpers.objects.ConversationVO
import com.example.messangerapi.helpers.objects.MessageVO
import com.example.messangerapi.models.Conversation
import com.example.messangerapi.services.ConversationServiceImpl
import org.springframework.stereotype.Component

@Component
class ConversationAssembler(
    val conversationService: ConversationServiceImpl,
    val messageAssembler: MessageAssembler
) {
    fun toConversationVO(
        conversation: Conversation,
        userId: Long
    ): ConversationVO {
        val conversationMessages: ArrayList<MessageVO> = ArrayList()
        conversation.messages?.mapTo(conversationMessages){
            messageAssembler.toMessageVO(it)
        }
        return ConversationVO(
            conversation.id,
            conversationService.nameSecondParty(conversation, userId),
            conversationMessages
        )
    }

    fun toConversationListVO(
        conversations: ArrayList<Conversation>,
        userId: Long
    ): ConversationListVO{
        val conversationVOList = conversations.map{toConversationVO(it, userId)}
        return ConversationListVO(conversationVOList)
    }

}
