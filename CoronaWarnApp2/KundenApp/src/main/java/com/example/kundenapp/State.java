package com.example.kundenapp;

public class State {
        public boolean checkin_active;
        public Integer checkin_duration;
        public boolean checkin_isNew;

        public State(){
                checkin_active = false;
                checkin_duration = 20;
                checkin_isNew = false;
        }
}
