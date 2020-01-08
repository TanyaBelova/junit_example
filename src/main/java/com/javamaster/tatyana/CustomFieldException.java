package com.javamaster.tatyana;

class CustomFieldException extends Exception {
        private String message;

        public CustomFieldException(String message)
        {
            this.message=message;
        }

    public String getMessage() {
        return message;
    }
}
