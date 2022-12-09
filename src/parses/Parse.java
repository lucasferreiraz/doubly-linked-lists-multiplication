package parses;

import structures.DoublyLinkedList;

public class Parse {

    private Long total = 0L;
    private int calls = 0;

    public DoublyLinkedList parseList(Long num) {

        DoublyLinkedList list = new DoublyLinkedList();

        int index = (int) (Math.ceil(num.toString().length() / 3.0) - 1);

        while (index >= 0) {
            list.addLast((long) (num / (Math.pow(1000, index)) % 1000));
            index--;
        }

        return list;
    }

    public DoublyLinkedList multiply(Long a, Long b) {
        DoublyLinkedList listOne;
        DoublyLinkedList listTwo;
        if(a < b){
            listOne = parseList(b);
            listTwo = parseList(a);  
        } else {
            listOne = parseList(a);
            listTwo = parseList(b);
        }

        // listOne > listTwo

        DoublyLinkedList finalResult = null;

        for (int i = listTwo.getSize() - 1; i >= 0; i--) {

            Long factorB = listTwo.getNode(i).getContent();

            DoublyLinkedList result = new DoublyLinkedList();

            Long dummy = 0L;

            for (int j = listOne.getSize() - 1; j >= 0; j--) {

                Long factorA = listOne.getNode(j).getContent();

                if (j == 0) {
                    result.add(0,
                            parseList(factorB * factorA + dummy).getLastNode());

                    if (parseList(factorB * factorA + dummy).getSize() > 1) {

                        dummy = parseList(factorB * factorA + dummy).getFirstNode();

                        result.add(0,
                                dummy);
                    }
                } else {
                    result.add(0,
                            parseList(factorB * factorA + dummy).getLastNode());

                    if (parseList(factorB * factorA + dummy).getSize() == 1) {
                        dummy = 0L;
                    } else {
                        dummy = parseList(factorB * factorA + dummy).getFirstNode();
                    }

                }

                finalResult = result;

            }

            sum(doublyLinkedListToInteger(finalResult));

        }

        return parseList(this.total);
    }

    private Long doublyLinkedListToInteger(DoublyLinkedList list){

        String build = "";

        for(int i = 0; i < list.getSize(); i++){

            Number tmp = (Number) list.getNode(i).getContent();
            Long number = tmp.longValue();

            if(number >= 0 && number < 10){
                build += "00" + number;
            } 
            else if(number > 10 && number < 100) {
                build += "0" + number;
            }
            else {
                build += number;
            }

        }

        return Long.parseLong(build);
    }

    private void sum(Long number){

        int factor = (int) Math.pow(1000, this.calls);

        this.total += number*factor;

        this.calls++;
    }

}
