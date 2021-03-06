package com.hlasm_plugin;

import com.intellij.codeInsight.editorActions.MultiCharQuoteHandler;
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.psi.tree.TokenSet;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 02.12.2016.
 */

/*public class HlasmQuoteHandler extends SimpleTokenSetQuoteHandler implements MultiCharQuoteHandler {
    public HlasmQuoteHandler() {super(HlasmParserDefenition.STRING);}

    @Nullable
    @Override
    public CharSequence getClosingQuote(HighlighterIterator iterator, int offset) {
        Document document = iterator.getDocument();
        if (document.getText().charAt(iterator.getStart()) == '\''){
            return "\'";
        }
        return null;
    }

    @Override
    public boolean hasNonClosedLiteral(Editor editor, HighlighterIterator iterator, int offset) {
        //return super.hasNonClosedLiteral(editor, iterator, offset);
        Document document = iterator.getDocument();
        if (document.getText().charAt(iterator.getStart()) == '\'' && document.getText().charAt(iterator.getEnd()) != '\''){
            return true;
        }
        return false;
    }
}
*/

/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//package com.intellij.ide.highlighter.custom.impl;

import com.intellij.codeInsight.editorActions.QuoteHandler;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.psi.CustomHighlighterTokenType;
import com.intellij.psi.tree.IElementType;

/**
 * @author Maxim.Mossienko
 */
public class HlasmQuoteHandler extends SimpleTokenSetQuoteHandler{//implements QuoteHandler {

    public HlasmQuoteHandler() {
        super(HlasmParserDefenition.STRING);
    }

    @Override
    protected boolean isNonClosedLiteral(HighlighterIterator iterator, CharSequence chars) {
        return iterator.getTokenType().equals(PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.STRING_ERROR));
    }

    @Override
    public boolean isOpeningQuote(HighlighterIterator iterator, int offset) {
        return myLiteralTokenSet.contains(iterator.getTokenType());
    }

    /*@Override
    public boolean isClosingQuote(HighlighterIterator iterator, int offset) {
        final IElementType tokenType = iterator.getTokenType();

        if (isQuotedToken(tokenType)){
            int start = iterator.getStart();
            int end = iterator.getEnd();
            return end - start >= 1 && offset == end - 1;
        }
        return false;
    }

    static boolean isQuotedToken(IElementType tokenType) {
        return HlasmParserDefenition.STRING.contains(tokenType);
//        return tokenType == CustomHighlighterTokenType.STRING ||
//                tokenType == CustomHighlighterTokenType.SINGLE_QUOTED_STRING ||
//                tokenType == CustomHighlighterTokenType.CHARACTER;
    }

    @Override
    public boolean isOpeningQuote(HighlighterIterator iterator, int offset) {
        if (isQuotedToken(iterator.getTokenType())){
            int start = iterator.getStart();
            return offset == start;
        }
        return false;
    }

    @Override
    public boolean hasNonClosedLiteral(Editor editor, HighlighterIterator iterator, int offset) {
        try {
            Document doc = editor.getDocument();
            CharSequence chars = doc.getCharsSequence();
            int lineEnd = doc.getLineEndOffset(doc.getLineNumber(offset));

            while (!iterator.atEnd() && iterator.getStart() < lineEnd) {
                if (isQuotedToken(iterator.getTokenType())) {

                    if (iterator.getStart() >= iterator.getEnd() - 1 ||
                            chars.charAt(iterator.getEnd() - 1) != '\"' && chars.charAt(iterator.getEnd() - 1) != '\'') {
                        return true;
                    }
                }
                iterator.advance();
            }
        } finally {
            while (!iterator.atEnd() && iterator.getStart() != offset) iterator.retreat();
        }

        return false;
    }

    @Override
    public boolean isInsideLiteral(HighlighterIterator iterator) {
        return isQuotedToken(iterator.getTokenType());
    }
    */
}
