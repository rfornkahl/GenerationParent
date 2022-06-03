package com.genparent.Generation.Parent.models.dto;

import com.genparent.Generation.Parent.models.Event;
import com.genparent.Generation.Parent.models.Tag;

import javax.validation.constraints.NotNull;

public class EventTagDTO {

        @NotNull
        private Event event;

        @NotNull
        private Tag tag;

        public EventTagDTO() {}

        public Event getEvent() {
            return event;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        public Tag getTag() {
            return tag;
        }

        public void setTag(Tag tag) {
            this.tag = tag;
        }

}
