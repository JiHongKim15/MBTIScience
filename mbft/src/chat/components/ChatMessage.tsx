import React from 'react';
import styled from 'styled-components';

//https://projects.verou.me/bubbly/
function ChatMessage() {

    const MessageStyle = styled.div`
        
        position: absolute;
        background: #a58af0;
        border-radius: .4em;
        padding : 10px;

        &:after {
            content: '';
            position: absolute;
            bottom: 0;
            left: 30%;
            width: 0;
            height: 0;
            border: 23px solid transparent;
            border-top-color: #a58af0;
            border-bottom: 0;
            border-left: 0;
            margin-left: -11.5px;
            margin-bottom: -23px;
        }
    `;
    return (
        <div className="ChatMessage">
            <MessageStyle>
                Hello World!
            </MessageStyle>
        </div>
    );
}

export default ChatMessage;