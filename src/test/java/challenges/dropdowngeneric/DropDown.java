package challenges.dropdowngeneric;

public enum DropDown {

    INDEX {
        @Override
        public String toString() {
            return "Index";
        }
    },

    VALUE {
        @Override
        public String toString() {
            return "value";
        }
    },

    VISIBLE_TEXT {
        @Override
        public String toString() {
            return "visibleText";
        }
    }
}
