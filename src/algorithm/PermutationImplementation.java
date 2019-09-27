/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

public class PermutationImplementation {
    
    private int key[];
    private int inverseKey[];
    private int blockLength;
    private char paddingChar;

    public PermutationImplementation(int[] key,char paddingChar) {
        this.key = key;
        this.inverseKey = inverseKey(key);
        this.paddingChar = paddingChar;
        this.blockLength = key.length;
    }
    
    public PermutationImplementation(int[] key) {
        this.inverseKey = key;
        this.key = this.inverseKey(inverseKey);
        this.paddingChar = '#';
        this.blockLength = key.length;
    }
    
    public String encrypt(String message)
    {
        String cipheredText = "";
        int lastBlock = (int) Math.ceil(message.length()/(double)blockLength);
        
        // Padding String If Length Is Not Multiple Of Block Length
        if( (message.length()%blockLength) != 0)
        {
            int diff = blockLength - (message.length()%blockLength);
            
            for(int i=0; i<diff; i++)
            {
                message+=paddingChar;
            }
        }
                
        for(int i=0; i < lastBlock; i++)
        {
            char[] blockArr = new char[blockLength];
            String block = message.substring(i*blockLength, i*blockLength+blockLength);
            
            for(int j=0; j<blockLength; j++)
            {
                blockArr[j] = block.charAt(key[j]-1);
            }
            
            String cipherBlock = new String(blockArr);
            cipheredText+=cipherBlock;

        }
        
        return cipheredText;
    }
    
    public String decrypt(String message)
    {
        int[] tempKey = key;
        key = inverseKey;
        String decryptedMessage = this.encrypt(message);
        key = tempKey;
        
        return decryptedMessage;
    }
    
    public int[] inverseKey(int key[])
    {
        int[] inverseKey = new int[key.length];
        
        for(int i=0; i<key.length; i++)
        {
            inverseKey[ key[i] - 1 ] = i + 1;
        }
        
        return inverseKey;
    }
    
    public String printInverseKey() {
        String output = "";
        
        for(int i=0; i<inverseKey.length; i++)
        {
            output+=inverseKey[i];
            if(i != inverseKey.length-1)
                output+=",";
        }
        
        return output;
    }
    
}
