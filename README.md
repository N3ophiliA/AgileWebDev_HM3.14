# AgileWebDev_HM3.14<br>
中文版<br>
一副扑克有52张牌，每张牌由一个花色和一个数字构成。<br>
花色为以下四者之一：<br>
方片 D<br>
黑桃 S<br>
红桃 H<br>
梅花 C<br>
数字为以下13者之一，且大小顺序如下：<br>
2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A<br>
花色是大小无序的，但数字有序，2最小，A最大。<br>
一手牌有5张。根据花色和数字的不同，其大小按照以下规则决定。<br>
满足下面规则的手牌会大于满足上面规则的手牌。<br>
同花顺＞铁支＞葫芦＞同花＞顺子＞三条＞两对＞对子＞散牌<br>
散牌：<br>
不符合其他任何规则的五张牌。 比较最大一张牌的大小，如果相同，比较第二大的牌的牌点数，如果五张牌的牌点数都相同，则为平局。<br>
对子：<br>
有两张同样大小的牌片。 比较两张大小一样的牌的牌点数，如果相同，依次比较剩余的三张牌大小。若大小都相同，则为平局。<br>
两对：
有两个对子牌。 比较大对子的大小，若相同，比较小对子的大小，若还相同，比较单张牌的大小，若还相同，则为平局。<br>
三条：<br>
有三张同样大小的牌片。 比较三张大小一样的牌的牌点数大小。<br>
顺子：<br>
五张相连的牌。 比较最大的牌点数。若大小都相同，则为平局。<br>
同花：<br>
五张牌的花色相同。 按照散排规则比较大小。<br>
葫芦：<br>
三条+对子。 比较三张大小一样的牌的牌点数。
铁支：<br>
有四张同样大小的牌片。 比较四张大小一样的牌的牌点数。
同花顺：<br>
同一种花色的顺子。 比较最大的牌的牌的大小。若大小都相同，则为平局。<br>
你的工作是为两手牌判断大小。<br>
例如：<br>
输入: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH 输出: White wins - high card: Ace<br>
输入: Black: 2H 4S 4C 2D 4H White: 2S 8S AS QS 3S 输出: Black wins - full house<br>
输入: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C KH 输出: Black wins - high card: 9<br>
输入: Black: 2H 3D 5S 9C KD White: 2D 3H 5C 9S KH 输出: Tie<br>
English version<br>
A poker deck contains 52 cards - each card has a suit which is one of clubs, diamonds, hearts, or spades (denoted C, D, H, and S in the input data).<br>
Each card also has a value which is one of 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace (denoted 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A).<br>
For scoring purposes, the suits are unordered while the values are ordered as given above, with 2 being the lowest and ace the highest value.<br>
A poker hand consists of 5 cards dealt from the deck. Poker hands are ranked by the following partial order from lowest to highest.<br>
High Card: Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are ranked by the next highest, and so on.<br>
Pair: 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.<br>
Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.<br>
Three of a Kind: Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.<br>
Straight: Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.<br>
Flush: Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.<br>
Full House: 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.<br>
Four of a kind: 4 cards with the same value. Ranked by the value of the 4 cards.<br>
Straight flush: 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.<br>
Your job is to rank pairs of poker hands and to indicate which, if either, has a higher rank.<br>
Examples:<br>
Input: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH Output: White wins - high card: Ace<br>
Input: Black: 2H 4S 4C 2D 4H White: 2S 8S AS QS 3S Output: Black wins - full house<br>
Input: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C KH Output: Black wins - high card: 9<br>
Input: Black: 2H 3D 5S 9C KD White: 2D 3H 5C 9S KH Output: Tie<br>
